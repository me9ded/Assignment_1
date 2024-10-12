/*
 * Students Names: Fouzi Haidar & Mohamed Amine Jmal
 * Student Number: 041157806 &     041138938
 * Professor Name: Paulo Sousa
 * Assignment 1
 * Description: Read the CSV, create proper classes, exception
handling, packages as well as perform operations using Collections (ArrayList), that
includes inclusion, edition, deletion and searching.*/
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
            if (title != null) {
                writer.write(String.join(",", title));
                writer.newLine();
            }

            for (AmazonProduct product : bestsellers) {
                StringBuilder productData = new StringBuilder();
                productData.append("\"").append(product.getId()).append("\",");
                productData.append("\"").append(product.getName()).append("\",");
                productData.append("\"").append(product.getMain_category().getCategory()).append("\",");
                productData.append("\"").append(product.getSub_category().getSubCategory()).append("\",");
                productData.append("\"").append(product.getImageURL()).append("\",");
                productData.append("\"").append(product.getLink()).append("\",");
                productData.append("\"").append(product.getRating()).append("\",");
                productData.append("\"").append(product.getNRatings()).append("\",");
                productData.append("\"").append(product.getDiscountPrice()).append("\",");
                productData.append("\"").append(product.getActualPrice()).append("\"");

                writer.write(productData.toString());
                writer.newLine();              
                }

            writer.flush();  
        } catch (IOException e) {
            throw new AmazonProductException("There was an error in saving the file.");
        }
    }





    public void printList(){
        for (AmazonProduct product : bestsellers) {
            System.out.println(product.toString());
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
    public void search(String data){
    	while(data.isEmpty()) {
    		System.out.println("Error data cannot be empty");
    		break;
    	}
    	if(!data.isEmpty()) {
    		for (AmazonProduct product : bestsellers) {
    			if (product.getName().toLowerCase().contains(data.toLowerCase())) {
    				System.out.println(product); 
    			}
    		}
    	}
    	
    }
    public int size() {
    	return bestsellers.size();
    	
    }
    public ArrayList<AmazonProduct> getBestSellers() {
    	return bestsellers;
    }
}
