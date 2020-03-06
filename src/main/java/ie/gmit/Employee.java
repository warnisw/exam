package ie.gmit;

public class Employee {
    private String title = "";
    private String name = "";
    private String pps = "";
    private String type = "";
    private long phone = 0;
    private int age = 0;


    public Employee(String title, String name,String pps, String type, long phone, int age) {
        setTitle(title);
        setName(name);
        setType(type);
        setPps(pps);
        setPhone(phone);
        setAge(age);
    }


    public void setTitle(String title) {
        if (title == "Mr" || title == "Mrs" || title == "Ms")
            this.title = title;
        else
            throw new IllegalArgumentException("Invalid title provided");
    }

    public void setName(String name) {
        if((name.length() < 3) || (name.length() >25)  )
            throw new IllegalArgumentException("Name must contain 3 - 25 characters");
        else
            this.name = name;
    }
    public void setPps (String pps) {
        if(pps.length() != 8)
            throw new IllegalArgumentException("PPS must contain 8 characters");
        else
            this.pps = pps;
    }

    public void setType(String type) {
        if(type == "Full-time" || type == "Part-time" || type == "Contract")
            this.type = type;
        else
            throw new IllegalArgumentException("Must contain employment type");
    }

    public void setPhone(long phone) {
        if(String.valueOf(phone).length() != 9)
            throw new IllegalArgumentException("Phone number must be 9 digits");
        else
            this.phone = phone;
    }

    public void setAge(int age) {
        if(age >= 16)
            this.age = age;
        else
            throw new IllegalArgumentException("Employee age must be over 16 to work in the company");

    }

    public String getTitle() { return title; }

    public String getName() { return name; }

    public String getType() { return type; }

    public String getPps() { return pps; }

    public long getPhone() { return phone; }

    public int getAge() { return age; }


}
