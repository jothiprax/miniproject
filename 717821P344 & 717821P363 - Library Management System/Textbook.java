class Textbook extends Book {
        private String subject;
        public Textbook(int id, String title, String author,int checking, String subject) {
            super(id, title, author,checking);
            this.subject = subject;
        }
        public String getSubject() {
            return subject;
        }
        public void setSubject(String subject) {
            this.subject = subject;
        }
    }


