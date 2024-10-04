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
