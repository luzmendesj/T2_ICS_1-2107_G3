import sintese.*;

public class instrumento2 {
	private Melodia mel1;
	
	private Oscilador osci1;
	
	private float freqCorte1, freqCorte2;
	
	private Ruido ruido1, ruido2;
	
	public instrumento2(){
		freqCorte1 = 1f;
		freqCorte2 = 100f;
		
		ruido1 = new Ruido();
		ruido2 = new Ruido();
		
		setFreqCorte(1, freqCorte1);
		setFreqCorte(2, freqCorte2);
		
		osci1 = new Oscilador(ruido1, ruido2);
		
		mel1 = ColecaoDeFrases.m23a();

	}
	public void tocar(){
		Som som1 = mel1.getSom(osci1);
		som1.setNome("instrumento2");
	    som1.salvawave();
	    som1.visualiza();
	}
	
	public void setFreqCorte(int numRuido, float freqCorte){
		switch(numRuido){
		case 1:
			ruido1.setFrequencia(freqCorte);
			break;
		case 2:
			ruido2.setFrequencia(freqCorte);
			break;
		default:
			
		}
	}

}
