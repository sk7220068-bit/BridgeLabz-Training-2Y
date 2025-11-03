interface LightBehavior {
    void activate();
}

public class SmartHomeLighting {
    public static void main(String[] args) {
        LightBehavior motionTrigger = () -> 
            System.out.println("💡 Motion detected! Turning ON lights.");

        LightBehavior nightTimeTrigger = () -> 
            System.out.println("🌙 Night mode activated: Setting warm dim lights.");

        LightBehavior voiceCommandTrigger = () -> 
            System.out.println("🎙️ Voice command received: Setting brightness to 80%.");

        simulateTrigger("motion", motionTrigger);
        simulateTrigger("night", nightTimeTrigger);
        simulateTrigger("voice", voiceCommandTrigger);
    }

    static void simulateTrigger(String triggerName, LightBehavior behavior) {
        System.out.println("\nTrigger: " + triggerName.toUpperCase());
        behavior.activate();
    }
}
