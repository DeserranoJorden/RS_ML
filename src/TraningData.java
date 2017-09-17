import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TraningData {

	private ArrayList<float[]> dataList;
	File file = null;
	
	public TraningData(String fileName) {
		file = new File(fileName);
		dataList = new ArrayList<float[]>();
	}

	public void add(float... data) {
		dataList.add(data);
	}
	
	public boolean save() {
		PrintWriter writer = null;
		
		if(file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		
		System.out.println("Saving: "+file.getAbsolutePath());
		try {
			writer = new PrintWriter(file);
			
			for(int i = 0; i < dataList.size();i++) {
				float[] data = dataList.get(i);
				String dataStr = "";
				for(int j = 0; j<data.length;j++) {
					if(j == 0)
						dataStr+=data[j];
					else 
						dataStr+=","+data[j];
				}
				//System.out.println(dataStr);
				writer.println(dataStr);
			} 
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			writer.close();
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public int getDataCount() {
		return dataList.size();
	}
	
	
}
