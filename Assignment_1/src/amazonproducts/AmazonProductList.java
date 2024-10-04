package amazonproducts;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class AmazonProductList extends AmazonProductUtil{
	
	Scanner input= new Scanner(System.in);
    private static final int NUMCOLS = 10;
    private String[] title;
    private ArrayList<AmazonProduct> bestsellers = new ArrayList<>();
    


    public void createList(String csvName) throws AmazonProductException, FileNotFoundException{
    	FileReader fl= new FileReader(csvName);
    	try (BufferedReader br=new BufferedReader(fl)){
    		String line=br.readLine();
    		title=line.split(",");
    		while((line=br.readLine()) != null) {
    			String[]temp=lineReader(line);
    			if(temp.length==NUMCOLS) {
    				AmazonProduct product =new AmazonProduct(temp);
    				bestsellers.add(product);
    			}
    		}

    	}catch(FileNotFoundException e) {
    		throw new AmazonProductException("Error file not found");
    		
    	}catch(IOException ae) {
    		throw new AmazonProductException("Error in reading the file");
    	}    
    }
    

    public void saveList(String csvName) throws AmazonProductException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvName))) {
        	 
            writer.write(String.join(",", AmazonProduct.getTitle()));
            writer.newLine();

 
            for (AmazonProduct product : bestsellers) {
                String productData = product.getId() + "," + product.getName() + "," +
                        product.getMain_category().getCategory() + "," +
                        product.getSub_category().getSubCategory() + "," +
                        product.getImageURL() + "," + product.getLink() + "," +
                        product.getRating() + "," + product.getNRatings() + "," +
                        product.getDiscountPrice() + "," + product.getActualPrice();
                writer.write(productData);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new AmazonProductException("There was an error in saving the file.");
        }
    }

    public void printList(){
        for (AmazonProduct product : bestsellers) {
            System.out.println(product);
        }
    }

    public void edit(int pos,AmazonProduct product) throws AmazonProductException{
    	if( pos < 0 || pos > bestsellers.size()) {
    		throw new AmazonProductException("Invalid position");
    	}
    	bestsellers.set(pos, product);
    }

    public void add(AmazonProduct product) throws AmazonProductException{
        bestsellers.add(product);
    }
    public void delete(int pos) throws AmazonProductException{
    	if( pos < 0 || pos > bestsellers.size()) {
    		throw new AmazonProductException("Invalid position");
    	}
    	bestsellers.remove(pos);
    }
    public AmazonProduct findProductByIndex(int pos) throws AmazonProductException{
    	if( pos < 0 || pos > bestsellers.size()) {
    		throw new AmazonProductException("Invalid position");
    	}
    	return bestsellers.get(pos);
    }
    public void search(String data) {
        for (AmazonProduct product : bestsellers) {
            if (product.getName().toLowerCase().contains(data.toLowerCase())) {
                System.out.println(product); 
            }
        }
    	
    }
    public int size() {
    	return bestsellers.size();
    	
    }
}
