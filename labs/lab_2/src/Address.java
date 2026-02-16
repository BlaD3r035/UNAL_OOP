public class Address {
    private String street;
    private String nomenclature;
    private String neighbourhood;
    private String city;
    private String building;
    private String apartment;

    public Address(String street, String nomenclature, String neighbourhood, String city, String building, String apartment){
        this.street = street;
        this.nomenclature = nomenclature;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.building = building;
        this.apartment = apartment;
    }
    public void setStreet(String street){
        this.street = street;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getStreet() {
        return this.street;
    }

    public String getNomenclature() {
        return this.nomenclature;
    }

    public String getNeighbourhood() {
        return this.neighbourhood;
    }

    public String getCity() {
        return this.city;
    }

    public String getBuilding() {
        return this.building;
    }

    public String getApartment() {
        return this.apartment;
    }
    public String toString(){
        return street + ", " + nomenclature + ", " + neighbourhood + ", " + city + ", " + building + ", " + apartment;
    }


}
