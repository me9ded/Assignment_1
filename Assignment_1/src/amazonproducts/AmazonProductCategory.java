/*
 * Students Names: Fouzi Haidar & Mohamed Amine Jmal
 * Student Number: 041157806 &     041138938
 * Professor Name: Paulo Sousa
 * Assignment 1
 * Description: Read the CSV, create proper classes, exception
handling, packages as well as perform operations using Collections (ArrayList), that
includes inclusion, edition, deletion and searching.*/
package amazonproducts;
public class AmazonProductCategory {
    private String categoryName;

    public AmazonProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategory() {
        return categoryName;
    }

    public void setCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}