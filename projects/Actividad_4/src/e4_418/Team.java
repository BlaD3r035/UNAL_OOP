package e4_418;

public class Team {
    String teamName;
    String university;
    String programmingLanguage;
    Developer[] developers;
    int teamSize ;

    Team(String teamName, String university, String programmingLanguage){
        this.teamName = teamName;
        this.university = university;
        this.programmingLanguage = programmingLanguage;
        teamSize = 0;
        developers = new Developer[3];
    }

    boolean isFull(){
        return  developers.length == teamSize;
    }

    void addDeveloper(Developer developer) throws Exception {
        if(isFull()){
            throw new Exception("The team is full (max 3 developers)");
        }
        developers[teamSize] = developer;
        teamSize++;
    }

    static void validateField(String field) throws Exception{
        for(int i = 0 ; i < field.length(); i++){
            char c = field.charAt(i);
            if(Character.isDigit(c)){
                throw new Exception("Name must not contain digits");
            }
        }
    }
}
