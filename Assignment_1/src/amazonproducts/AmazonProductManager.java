/*
 * Students Names: Fouzi Haidar & Mohamed Amine Jmal
 * Student Number: 041157806 &     041138938
 * Professor Name: Paulo Sousa
 * Assignment 1
 * Description: Read the CSV, create proper classes, exception
handling, packages as well as perform operations using Collections (ArrayList), that
includes inclusion, edition, deletion and searching.*/
package amazonproducts;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AmazonProductManager {
    private static Scanner input = new Scanner(System.in);
    private static AmazonProductList productList = new AmazonProductList(); 
    private static final int EXIT_OPTION = 0;
    private static final int LOAD_LIST = 1;
    private static final int SHOW_LIST = 2;
    private static final int ADD_PRODUCT = 3;
    private static final int EDIT_PRODUCT = 4;
    private static final int DELETE_PRODUCT = 5;
    private static final int SAVE_LIST = 6;
    private static final int SEARCH_LIST = 7;


    public static void showMenu() {
        System.out.println("================================");
        System.out.println("|| Menu - Amazon Products: A1 ||");
        System.out.println("================================");
        System.out.println("0. Exit");
        System.out.println("1. Load product list");
        System.out.println("2. Show product list");
        System.out.println("3. Add product");
        System.out.println("4. Edit a product");
        System.out.println("5. Delete a product");
        System.out.println("6. Save product list");
        System.out.println("7. Search in the list");
        System.out.println("Choose an option:");
    }


    public void manageProductList() throws AmazonProductException, FileNotFoundException {
        int userInput = -1;

        while (userInput != EXIT_OPTION) {
            showMenu();
            try {
                userInput = input.nextInt();
                switch (userInput) {
                    case EXIT_OPTION:
                        exit();
                        break;
                    case LOAD_LIST:
                        createProductList();
                        break;
                    case SHOW_LIST:
                        displayProductList();
                        break;
                    case ADD_PRODUCT:
                        addProduct();
                        break;
                    case EDIT_PRODUCT:
                        editProduct();
                        break;
                    case DELETE_PRODUCT:
                        deleteProduct();
                        break;
                    case SAVE_LIST:
                        saveProductList();
                        break;
                    case SEARCH_LIST:
                        search();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                input.next(); 
            }
        }
    }

        public static void exit() {
        	System.out.println("Exiting...");
        	System.out.println("Program done by : Fouzi Haider and Mohamed amine jmal");
    }


    public static void createProductList() throws AmazonProductException, FileNotFoundException{
    	String local_temp="Sample-Amazon-Products-v2.csv";
    	productList.createList(local_temp);
        System.out.println("Loading product list...");
        
    }


    public static void displayProductList(){
    	productList.printList();
        System.out.println("Displaying product list...");
    }

    public static void addProduct() throws AmazonProductException {
    	 	int id = getInt("ID: ");
    	    String name = getString("Name: ");
    	    input.nextLine();
    	    AmazonProductCategory category = new AmazonProductCategory(getString("Category: "));
    	    AmazonProductSubCategory subCategory = new AmazonProductSubCategory(getString("Sub-category: "), category);
    	    String imageURL = getString("Image URL: ");
    	    String link = getString("Link: ");
    	    float rating = getFloat("Rating: ");
    	    int nRatings = getInt("Number of Ratings: ");
    	    float discountPrice = getFloat("Discount Price: ");
    	    float actualPrice = getFloat("Actual Price: ");

    	    AmazonProduct newProduct = new AmazonProduct(id, name, category, subCategory, imageURL, link, rating, nRatings, discountPrice, actualPrice);
    	    productList.add(newProduct);
    	    System.out.println("Product has been added successfully.");
    	}
    


    public static void editProduct() throws AmazonProductException{
        System.out.print("Enter product position (0 to " + (productList.size() - 1) + "): ");
        int pos = input.nextInt();
        if (pos < 0 || pos >= productList.size()) {
            System.out.println("Invalid position."); return;
        }
        input.nextLine(); 

        productList.edit(pos, new AmazonProduct(
            getInt("ID: "), getString("Name: "), 
            new AmazonProductCategory(getString("Category: ")),
            new AmazonProductSubCategory(getString("Sub-category: "), new AmazonProductCategory(getString("Main Category: "))),
            getString("Image URL: "), getString("Link: "),
            getFloat("nRating: "), getInt("Number of Ratings: "),
            getFloat("Discount Price: "), getFloat("Actual Price: ")
        ));
        System.out.println("Product updated successfully.");
    }

    private static int getInt(String prompt) {
        System.out.print(prompt); return input.nextInt();
    }

    private static float getFloat(String prompt) {
        System.out.print(prompt); return input.nextFloat();
    }

    private static String getString(String prompt) {
        System.out.print(prompt); return input.nextLine();
    }
    

    public static void deleteProduct() throws AmazonProductException{
        System.out.print("Enter where in the position of the product to delete (0 to " + (productList.size() - 1) + "): ");
        int pos = input.nextInt();


        if (pos < 0 || pos >= productList.size()){
            System.out.println("Invalid position.");
            return;
        }

        productList.delete(pos);
        System.out.println("Product has been deleted successfully.");
    }

      public static void saveProductList() throws AmazonProductException {
   
    	  productList.saveList("productList2.csv");
      }
    public static void search(){
//    	try {
//            System.out.print("Enter the product name to search: ");
//            input.nextLine();
//            String keyword = input.nextLine();
//            productList.search(keyword);
//            System.out.println("A moment it is searching in the product list...");
//    	}catch (AmazonProductException e){
//            System.err.println("AmazonProductException: " + e.getMessage());
//
//    	}
    	System.out.println("Enter the product name to search: ");
       input.nextLine();
       String keyword = input.nextLine();
       productList.search(keyword);
    	

    }
    

    public static void main(String[] args) throws AmazonProductException, FileNotFoundException {
        AmazonProductManager manager = new AmazonProductManager();
        manager.manageProductList();
    }
}
