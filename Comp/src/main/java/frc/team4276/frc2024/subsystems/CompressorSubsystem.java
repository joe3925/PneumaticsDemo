package frc.team4276.frc2024.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class CompressorSubsystem extends SubsystemBase{
    private static Compressor m_compressor;
    public CompressorSubsystem(){
        m_compressor = new Compressor(PneumaticsModuleType.REVPH);
        m_compressor.disable();
    }
    boolean isEnabled(){
        return m_compressor.isEnabled();
    }
    Command disable(){
        return runOnce(() -> {
            m_compressor.disable();
        });
    }
    public Command enable(){
        return runOnce(() -> {
             m_compressor.enableDigital();
        });
    }

}
