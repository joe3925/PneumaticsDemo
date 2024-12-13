package frc.team4276.frc2024.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team4276.frc2024.Ports;

public class DoubleSolenoidSubsystem extends SubsystemBase {
    private static DoubleSolenoidSubsystem instance;
    private static DoubleSolenoid m_doubleSolenoid;

    private DoubleSolenoidSubsystem() {
        m_doubleSolenoid = PneumaticFactory.makeDoubleSolenoid(Ports.DoubleSolenoid.forwardChannel, Ports.DoubleSolenoid.reverseChannel); 
        //this will register the subsystem
        setDefaultCommand(stop());
    }

    public static DoubleSolenoidSubsystem getInstance() {
        if (instance == null) {
            instance = new DoubleSolenoidSubsystem();
        }
        return instance;
    }

    public Command stop() {
        return run(() -> {
            m_doubleSolenoid.set(DoubleSolenoid.Value.kOff);
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
