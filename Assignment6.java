import java.io.*;

class Assignment6
{
	public static void main(String[] args) 
	{
		int rollNo=0;
		String name="";
		int age=0;
		double height=0.0;
		double weight=0.0;
		String city="";
		long phoneNo=0;


		DataOutputStream dos=null;
		FileOutputStream fos=null;
		BufferedReader br=null;
		try
		{
			fos=new FileOutputStream("stu.dat",true);
			dos=new DataOutputStream(fos);
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		catch(Exception e){}
		while(true)
		{
			System.out.print("\n\n Student Information");
			System.out.print("\n\n Roll no (0 to exit): ");
			try{
				rollNo=Integer.parseInt(br.readLine());
			}
			catch(IOException e){System.out.println(" Enter roll no correctly");continue;}
			if(rollNo==0)
				break;
			try{
				
				System.out.print(" Name: ");
				name=br.readLine();
				System.out.print(" Age: ");
				age=Integer.parseInt(br.readLine());
				System.out.print(" Height (cm): ");
				height=Double.parseDouble(br.readLine());
				System.out.print(" Weight (kg): ");
				weight=Double.parseDouble(br.readLine());
				System.out.print(" City: ");
				city=br.readLine();
				System.out.print(" Phone No: ");
				phoneNo=Long.parseLong(br.readLine());
			}catch(IOException e){System.out.println(" Enter data correctly");continue;}
			try
			{
				dos.writeInt(rollNo);
				dos.writeUTF(name);
				dos.writeInt(age);
				dos.writeDouble(height);
				dos.writeDouble(weight);
				dos.writeUTF(city);
				dos.writeLong(phoneNo);
			}
			catch(Exception e){System.out.println(" Error in data writing to file");}
		}
		try
		{
			fos.close();
			dos.close();
		}
		catch(Exception e){System.out.println(" Error in close streams");}

		DataInputStream dis=null;
		FileInputStream fis=null;
		try{
			fis=new FileInputStream("stu.dat");
			dis=new DataInputStream(fis);
		}
		catch(Exception e){System.out.println(" File Not Found");}
		System.out.println("\n\n Data in File:\n\n");
		while(true)
		{
			try
			{
				rollNo=dis.readInt();
				name=dis.readUTF();
				age=dis.readInt();
				height=dis.readDouble();
				weight=dis.readDouble();
				city=dis.readUTF();
				phoneNo=dis.readLong();
			}
			catch(Exception e){break;}

			String data=" Roll no: "+rollNo+"\n Name: "+name+"\n Age: "+age+"(years)  Height: "+height+"(cm)  Weight: "+weight+"(kg)\n City: "+city+"  Phone No: "+phoneNo;
			System.out.println(data+"\n\n");
		} 
		try
		{
			fis.close();
			dis.close();
		}
		catch(Exception e){System.out.println(" Error in close streams");}
	}
}