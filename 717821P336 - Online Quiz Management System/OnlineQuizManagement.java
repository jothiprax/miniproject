import java.sql.*;
import java.util.*;

class QuizNotFoundException extends Exception {
    public QuizNotFoundException(String message) {
        super(message);
    }
}

class Quiz {
    private int quizId;
    private String quizName;
    private int duration;
    private List<Question> questions;

    public Quiz(int quizId, String quizName, int duration) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.duration = duration;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        int score = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Starting Quiz: " + quizName);
            System.out.println("Duration: " + duration + " minutes");

            for (Question question : questions) {
                System.out.println(question.getQuestion());
                for (int i = 0; i < question.getOptions().size(); i++) {
                    System.out.println((i + 1) + ". " + question.getOptions().get(i));
                }
                System.out.print("Your answer (1-" + question.getOptions().size() + "): ");
                int userAnswer = scanner.nextInt();
                if (userAnswer == question.getCorrectAnswer()) {
                    score++;
                }
            }
        }

        System.out.println("Quiz finished!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

class Question {
    private String question;
    private List<String> options;
    private int correctAnswer;

    public Question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

class QuizManager {
    private Connection connection;

    public QuizManager(Connection connection) {
        this.connection = connection;
    }

    public void createQuiz(String quizName, int duration) throws SQLException {
        String sql = "INSERT INTO quizzes (quiz_name, duration) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, quizName);
        statement.setInt(2, duration);
        statement.executeUpdate();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int quizId = generatedKeys.getInt(1);
            System.out.println("Quiz created with ID: " + quizId);
        }

        statement.close();
    }

    public void addQuestionToQuiz(int quizId, Question question) throws SQLException, QuizNotFoundException {
        if (!quizExists(quizId)) {
            throw new QuizNotFoundException("Quiz with ID " + quizId + " does not exist.");
        }

        String sql = "INSERT INTO questions (quiz_id, question, options, correct_answer) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, quizId);
        statement.setString(2, question.getQuestion());
        statement.setString(3, String.join(",", question.getOptions()));
        statement.setInt(4, question.getCorrectAnswer());
        statement.executeUpdate();

        System.out.println("Question added to Quiz with ID: " + quizId);

        statement.close();
    }
    public void startQuiz(int quizId) throws SQLException, QuizNotFoundException {
        if (!quizExists(quizId)) {
            throw new QuizNotFoundException("Quiz with ID " + quizId + " does not exist.");
        }

        String sql = "SELECT * FROM questions WHERE quiz_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, quizId);
        ResultSet resultSet = statement.executeQuery();

        Quiz quiz = null;

        while (resultSet.next()) {
            if (quiz == null) {
                int duration = getQuizDuration(quizId);
                String quizName = getQuizName(quizId);
                quiz = new Quiz(quizId, quizName, duration);
            }

            String questionText = resultSet.getString("question");
            String optionsText = resultSet.getString("options");
            int correctAnswer = resultSet.getInt("correct_answer");

            List<String> options = new ArrayList<>();
            for (String option : optionsText.split(",")) {
                options.add(option);
            }

            Question question = new Question(questionText, options, correctAnswer);
            quiz.addQuestion(question);
        }

        statement.close();

        if (quiz != null) {
            quiz.startQuiz();
        } else {
            throw new QuizNotFoundException("No questions found for Quiz with ID " + quizId);
        }
    }

    private boolean quizExists(int quizId) throws SQLException {
        String sql = "SELECT * FROM quizzes WHERE quiz_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, quizId);
        ResultSet resultSet = statement.executeQuery();
        boolean exists = resultSet.next();
        statement.close();
        return exists;
    }

    private int getQuizDuration(int quizId) throws SQLException {
        String sql = "SELECT duration FROM quizzes WHERE quiz_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, quizId);
        ResultSet resultSet = statement.executeQuery();
        int duration = -1;
        if (resultSet.next()) {
            duration = resultSet.getInt("duration");
        }
        statement.close();
        return duration;
    }

    private String getQuizName(int quizId) throws SQLException {
        String sql = "SELECT quiz_name FROM quizzes WHERE quiz_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, quizId);
        ResultSet resultSet = statement.executeQuery();
        String quizName = "";
        if (resultSet.next()) {
            quizName = resultSet.getString("quiz_name");
        }
        statement.close();
        return quizName;
    }
}

public class OnlineQuizManagement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JP", "root", "Manoj@2004");
            QuizManager quizManager = new QuizManager(connection);

            // Create Quiz
            quizManager.createQuiz("Math Quiz", 10);

            // Add Questions to Quiz
            Question question1 = new Question("What is 2 + 2?",Arrays.asList("2", "3", "4", "5"), 3);
            Question question2 = new Question("What is the capital of France?",Arrays.asList("London", "Paris", "Madrid", "Berlin"), 2);
            quizManager.addQuestionToQuiz(1, question1);
            quizManager.addQuestionToQuiz(1, question2);

            // Start Quiz
            quizManager.startQuiz(1);

            connection.close();
        } catch (ClassNotFoundException | SQLException | QuizNotFoundException e) {
            e.printStackTrace();
        }
    }
}
