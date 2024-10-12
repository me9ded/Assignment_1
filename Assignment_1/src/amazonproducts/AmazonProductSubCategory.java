/*
 * Students Names: Fouzi Haidar & Mohamed Amine Jmal
 * Student Number: 041157806 &     041138938
 * Professor Name: Paulo Sousa
 * Assignment 1
 * Description: Read the CSV, create proper classes, exception
handling, packages as well as perform operations using Collections (ArrayList), that
includes inclusion, edition, deletion and searching.*/
package amazonproducts;
public class AmazonProductSubCategory {

    private AmazonProductCategory category;
    private String subCategoryName;


    public AmazonProductSubCategory(String subCategoryName, AmazonProductCategory category) {
        this.subCategoryName = subCategoryName;
        this.category = category;
    }


    public AmazonProductCategory getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategoryName;
    }

    
    public void setCategory(AmazonProductCategory category) {
        this.category = category;
    }

    
    public void setSubCategory(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
}
