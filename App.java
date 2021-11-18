/**
 * 
 */

/**
 * @author JP
 *
 */
/**
 * Class App.
 */
public class App {
    private String name;
    private String about;
    private String platform;
    private String versions;
    private String price;
    private String category;
    private String storeName;
    private String storeLink;

    public App(String name, String about, String platform, String versions,
    		String price, String category, String storeName, String storeLink) {
        this.name = name;
        this.about = about;
        this.platform = platform;
        this.versions = versions;
        this.price = price;
        this.category = category;
        this.storeName = storeName;
        this.storeLink = storeLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return the versions
     */
    public String getVersions() {
        return versions;
    }

    /**
     * @param versions the versions to set
     */
    public void setVersions(String versions) {
        this.versions = versions;
    }

    /**
     * @return the storeLink
     */
    public String getStoreLink() {
        return storeLink;
    }

    /**
     * @param storeLink the storeLink to set
     */
    public void setStoreLink(String storeLink) {
        this.storeLink = storeLink;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * @param storeName the storeName to set
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "App [name=" + name + ", about=" + about + ", platform="
                + platform + ", versions=" + versions + ", storeLink="
                + storeLink + ", price=" + price + ", category=" + category
                + ", storeName=" + storeName + "]";
    }
}
