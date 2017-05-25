import sintese.*;

public class instrumento1 {
	Curva        curva1, curva2, curva3, curva4;
	   
	   Oscilador osci1;
	   
	   Melodia mel1;
	   
	   float ganho1, ganho2, ganho3, ganho4, ganhoTotal;
	   float h1, h2, h3;
	   float lambda1, lambda2, lambda3;
	   float fase1, fase2, fase3;
	   
	   Envoltoria   env1, env2, env3, env4;
	   
	   InstrumentoAditivo ins;   
	    
	   UnidadeH     uh1;
	   UnidadeH     uh2;
	   UnidadeH     uh3;
	public instrumento1(){
		ganho1 = 1;
		ganho2 = 1;
		ganho3 = 1;
		ganho4 = 4;
		ganhoTotal = 4;
		
		h1 = 3;
		h2 = 5;
		h3 = 7;
		
		lambda1 = 0f;
		lambda2 = 0f;
		lambda3 = 0f;
		
		fase1 = 0;
		fase2 = 0;
		fase3 = 0;
		
		env1 = new Envoltoria();   
	    env2 = new Envoltoria();   
	    env3 = new Envoltoria();   
	    env4 = new Envoltoria();
	  
	    uh1 = new UnidadeH();
	    uh2 = new UnidadeH();
	    uh3 = new UnidadeH();
	    
	    curva1 = new Curva(720);     
	    curva1.addPonto(  0f, 20f);
	    curva1.addPonto(72f, 1500f);
	    curva1.addPonto(400f, 200f);
	    curva1.addPonto(720f, 0f);     
	
	    curva2 = new Curva(720);     
	    curva2.addPonto(0f, 30f);   
	    curva2.addPonto(50f, 2000f);
	    curva2.addPonto(550f, 500f);
	    curva2.addPonto(720f, 0f);     
	
	    curva3 = new Curva(720);     
	    curva3.addPonto(0f, 40f);   
	    curva3.addPonto(80f, 1000f);
	    curva3.addPonto(600f, 100f);
	    curva3.addPonto(720f, 0f);
	    
	    curva4 = new Curva(720);     
	    curva4.addPonto(0f, 500f);
	    curva4.addPonto(90f, 500f);
	    curva4.addPonto(180f, 1000f);
	    curva4.addPonto(360f, 1000f);
	    curva4.addPonto(440f, 500f);
	    curva4.addPonto(720f, 0f);
	    
	    env1.setCURVA(curva1);      
	    env2.setCURVA(curva2);    
	    env3.setCURVA(curva3);    
	    env4.setCURVA(curva4);
	    
	    env4.setGanho(ganho4);
	    
	    uh1.setEnvoltoria(env1);
	     uh1.setH(h1);
	     uh1.setLambda(lambda1);
	     uh1.setFase(fase1);
	     uh1.setGanho(ganho1);

	     uh2.setEnvoltoria(env2);
	     uh2.setH(h2);
	     uh2.setLambda(lambda2);
	     uh2.setFase(fase2);
	     uh2.setGanho(ganho2);
	     
	     uh3.setEnvoltoria(env3);
	     uh3.setH(h3);
	     uh3.setLambda(lambda3);
	     uh3.setFase(fase3);
	     uh3.setGanho(ganho3);

	     ins = new InstrumentoAditivo();

	     ins.addUnidade(uh1);
	     ins.addUnidade(uh2);
	     ins.addUnidade(uh3);
	     ins.setGanho(ganhoTotal);
	     
	     osci1 = new Oscilador(env4, ins);

	     mel1 = ColecaoDeFrases.m23a();
	}
        
	public void tocar(){
            /*
            float ganho1, ganho2, ganho3, ganho4, ganhoTotal;
	   float h1, h2, h3;
	   float lambda1, lambda2, lambda3;
            */
            System.out.println( );
            System.out.println( ganho1 + " / " + h1 );
            System.out.println( ganho2 + " / " + h2 );
            System.out.println( ganho3 + " / " + h3 );
            System.out.println( ganho4 );
            System.out.println( ganhoTotal );
            
		Som som1 = mel1.getSom(osci1);
		som1.setNome("instrumento1");
	     som1.salvawave();
	     som1.visualiza();
	}
	
	public void setHarmonico(int numH, float novoH){
		switch(numH){
		case 1:
			h1 = novoH;
			uh1.setH(h1);
			break;
		case 2:
			h2 = novoH;
			uh2.setH(h2);
			break;
		case 3:
			h3 = novoH;
			uh3.setH(h3);
			break;
		default:
			
		}
	}
	
	public void setMelodia( String mel ){
            String melodia[]={"Escolher Melodia","fraseparacorneingles","m23a","m25","m9_la_menor", 
                    "segundamenor_trombone", "tercamaior2_harpa"};    
            
            if( mel.equals( melodia[1] ) == true ){
                mel1 = ColecaoDeFrases.fraseparacorneingles();
            } else if( mel.equals( melodia[3] ) == true ){
                mel1 = ColecaoDeFrases.m25();
            } else if( mel.equals( melodia[4] ) == true ){
                mel1 = ColecaoDeFrases.m9_la_menor();
            } else if( mel.equals( melodia[5] ) == true ){
                mel1 = ColecaoDeFrases.segundamenor_trombone();
            } else if( mel.equals( melodia[6] ) == true ){
                mel1 = ColecaoDeFrases.tercamaior2_harpa();
            } else {
                mel1 = ColecaoDeFrases.m23a();
            }
	}
	
	public void setGanho(int numGanho, float novoGanho){
		switch(numGanho){
		case 1:
			ganho1 = novoGanho;
			uh1.setGanho(ganho1);
			break;
		case 2:
			ganho2 = novoGanho;
			uh2.setGanho(ganho2);			
			break;
		case 3:
			ganho3 = novoGanho;
			uh3.setGanho(ganho3);
			break;
		case 4:
			ganho4 = novoGanho;
			env4.setGanho(ganho4);
			break;
		case 0:
			ganhoTotal = novoGanho;
			ins.setGanho(ganhoTotal);
			break;
		default:
			
		}
	}
	
}
