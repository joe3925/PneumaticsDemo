package frc.team4276.frc2024.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class doubleSolenoidSubsystem extends SubsystemBase{
      private DoubleSolenoid m_doubleSolenoid;
      private boolean running = false;
      public doubleSolenoidSubsystem(){
        m_doubleSolenoid =  new DoubleSolenoid(PneumaticsModuleType.REVPH, 1, 2);
        setDefaultCommand(stop());

      }
      public Command forward(){
        running = true;
        return run(() -> {
            m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
        });
      }
      public Command reverse(){
        running = true;
        return run(() -> {
            m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        });
      }
      Command stop(){
        return run(() -> {
            while(true){
                m_doubleSolenoid.set(DoubleSolenoid.Value.kOff);
            }
        });
      }
      @Override
      public void periodic(){
        if(!running){
            m_doubleSolenoid.set(DoubleSolenoid.Value.kOff);
        }
      }
}
