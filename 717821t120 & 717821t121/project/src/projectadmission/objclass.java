package projectadmission;

public class objclass extends choices{

	public static void main(String[] args)  {
		choices ch = new choices();
		ch.choice();
		teacher t=new teacher();
		t.information1(input.choice);
		student st= new student();
		st.information2(input.choice);
		query q= new query();
		try {
			if(input.choice==1)
			{
				try {
					q.teacherconnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(input.choice==2)
			{
				try {
					q.studentconnection();
				} catch (Exception e) 
				{
				e.printStackTrace();
				}
			}
			else if(input.choice != 1 && input.choice !=2)
			{
				try {
					throw new wrongnumberException("The number entered is Wrong Input");
				}
				
				catch(wrongnumberException e)
				{
					System.out.println(e);
				}
		}
		}
			catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
