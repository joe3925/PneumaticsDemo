package frc.team4276.frc2024.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DoubleSolenoidSubsystem extends SubsystemBase {
    private static DoubleSolenoidSubsystem instance; // Singleton instance
    private DoubleSolenoid m_doubleSolenoid;

    // Private constructor to prevent external instantiation
    private DoubleSolenoidSubsystem() {
        m_doubleSolenoid = PneumaticFactory.makeDoubleSolenoid(1, 2); // Assuming PneumaticFactory is a valid factory class
        setDefaultCommand(stop());
    }

    // Public static method to provide access to the single instance
    public static DoubleSolenoidSubsystem getInstance() {
        if (instance == null) {
            synchronized (DoubleSolenoidSubsystem.class) { // Ensure thread-safety
                if (instance == null) {
                    instance = new DoubleSolenoidSubsystem();
                }
            }
        }
        return instance;
    }

    Command stop() {
        return run(() -> {
            while (true) {
                m_doubleSolenoid.set(DoubleSolenoid.Value.kOff);
            }
        });
    }

    public Command forward() {
        return run(() -> {
            m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
        });
    }

    public Command reverse() {
        return run(() -> {
            m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        });
    }
}
