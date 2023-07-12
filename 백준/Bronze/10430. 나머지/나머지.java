import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A=scan.nextInt();
		int B=scan.nextInt();
		int C=scan.nextInt();
		
		List result= new ArrayList();
		result.add((A+B)%C);
		result.add((A%C + B%C)%C);
		result.add((A*B)%C);
		result.add((A%C * B%C)%C);
		
		
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));

		
		
		
		
	}

}
