// MealPlanGenerator.java
interface MealPlan { String getType(); }
class VegetarianMeal implements MealPlan { public String getType(){return "Vegetarian";} }
class VeganMeal implements MealPlan { public String getType(){return "Vegan";} }
class KetoMeal implements MealPlan { public String getType(){return "Keto";} }

class Meal<T extends MealPlan> {
    private T plan;
    Meal(T plan){ this.plan = plan; }
    public void showPlan(){ System.out.println("Meal Type: " + plan.getType()); }
}

public class MealPlanGenerator {
    public static <T extends MealPlan> void generatePlan(Meal<T> meal){
        System.out.println("Generating plan for: " + meal);
    }

    public static void main(String[] args){
        Meal<VegetarianMeal> veg = new Meal<>(new VegetarianMeal());
        veg.showPlan();
    }
}
