package frc.team4276.frc2024.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;

/**supplies a solenoid object for a given channel or this hubs compressor*/
public class PneumaticFactory{
    private static PneumaticHub m_pH = new PneumaticHub(1);
    private static compressorSubsystem m_compressor = new compressorSubsystem(m_pH.makeCompressor());

    public static DoubleSolenoid makeDoubleSolenoid(int forwardChannel, int reverseChannel) {
        return m_pH.makeDoubleSolenoid(forwardChannel, reverseChannel);
    }
    public static Solenoid makeSolenoid(int forwardChannel) {
        return m_pH.makeSolenoid(forwardChannel);
    }
    public static compressorSubsystem getCompressorSubsystem(){
        return m_compressor;
    }
}
