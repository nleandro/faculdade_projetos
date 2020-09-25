package br.edu.map2.formula1.factorymethod;

import br.edu.map2.formula1.model.Carro;
import br.edu.map2.formula1.model.CarroFormula1;
import br.edu.map2.formula1.model.FreioABS;
import br.edu.map2.formula1.model.IFreio;
import br.edu.map2.formula1.model.IMotor;
import br.edu.map2.formula1.model.IPneu;
import br.edu.map2.formula1.model.ISuspensao;
import br.edu.map2.formula1.model.Modelo;
import br.edu.map2.formula1.model.Montadora;
import br.edu.map2.formula1.model.MotorV6TurboHibrido;
import br.edu.map2.formula1.model.MotorV8Turbo;
import br.edu.map2.formula1.model.PneuDuro;
import br.edu.map2.formula1.model.PneuMacio;
import br.edu.map2.formula1.model.SuspensaoPadrao;
import java.util.ArrayList;

public class CarroFactoryMethod implements ICarroFactoryMethod {

    //Montadora
    public static final int FERRARI = 1;
    public static final int MERCEDES = 2;
    public static final int RENAULT = 3;
    public static final int MCLAREN = 4;
    //Motor
    public static final int MOTORV8TURBO = 5;
    public static final int MOTORV6TURBOHIBRIDO = 6;
    //Pneu
    public static final int PNEUDURO = 7;
    public static final int PNEUMACIO = 8;

    private final IFreio freio;
    private final ISuspensao suspensao;
    private IMotor motor;
    private Montadora montadora;
    private Modelo modelo;
    private IPneu pneu;
    private ArrayList<IPneu> conjuntoPneus;

    public CarroFactoryMethod() {
        this.freio = new FreioABS();
        this.suspensao = new SuspensaoPadrao();
    }

    @Override
    public Carro criarCarroF1(int montadora, int motor, int pneu) {

        switch (montadora) {
            case CarroFactoryMethod.FERRARI:
                this.montadora = new Montadora("Ferrari");
                this.modelo = new Modelo("Scuderia Ferrari F1", this.montadora);
                break;
            case CarroFactoryMethod.MERCEDES:
                this.montadora = new Montadora("Mercedes");
                this.modelo = new Modelo("Mercedes-AMG F1", this.montadora);
                break;
            case CarroFactoryMethod.RENAULT:
                this.montadora = new Montadora("Renault");
                this.modelo = new Modelo("Renault F1", this.montadora);
                break;
            case CarroFactoryMethod.MCLAREN:
                this.montadora = new Montadora("McLaren");
                this.modelo = new Modelo("McLaren F1", this.montadora);
                break;
            default:
                return null;
        }

        switch (motor) {
            case CarroFactoryMethod.MOTORV8TURBO:
                this.motor = new MotorV8Turbo("Motor V8 Turbo");
                break;
            case CarroFactoryMethod.MOTORV6TURBOHIBRIDO:
                this.motor = new MotorV6TurboHibrido("Motor V6 Turbo Híbrido");
                break;
            default:
                return null;
        }

        switch (pneu) {
            case CarroFactoryMethod.PNEUDURO:
                this.pneu = new PneuDuro();

                this.conjuntoPneus = new ArrayList<>();

                for (int i = 0; i < 4; i++) {
                    this.conjuntoPneus.add(this.pneu);
                }
                break;
            case CarroFactoryMethod.PNEUMACIO:
                this.pneu = new PneuMacio();

                this.conjuntoPneus = new ArrayList<>();

                for (int i = 0; i < 4; i++) {
                    this.conjuntoPneus.add(this.pneu);
                }
                break;
            default:
                return null;
        }

        return new CarroFormula1(this.motor, this.freio, this.modelo, this.suspensao, this.conjuntoPneus);

    }

}
