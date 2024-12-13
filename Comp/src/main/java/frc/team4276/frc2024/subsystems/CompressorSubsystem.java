package frc.team4276.frc2024.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CompressorSubsystem extends SubsystemBase {
    private Compressor m_compressor;
    public CompressorSubsystem(Compressor m_Compressor){
        m_Compressor.disable();
        m_compressor = m_Compressor;
    }
    public boolean isEnabled(){
        return m_compressor.isEnabled();
    }
    public Command disable(){
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
