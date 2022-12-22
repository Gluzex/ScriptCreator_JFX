import javafx.stage.Stage;

public class ResetAction {
    private Stage mnf;
    public ResetAction(Stage mnf){
            this.mnf = mnf;
            mnf.setWidth(520);
            mnf.setHeight(240);
            SC_data_miner.SC_data_cleaner();
        }

}
