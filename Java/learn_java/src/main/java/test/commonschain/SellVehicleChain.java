package test.commonschain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;

/**
 * @author chuanshi - 2018-12-05 11:26
 */
public class SellVehicleChain extends ChainBase {

    public SellVehicleChain() {
        super();
        addCommand(new GetCustomerInfo());
        addCommand(new TestDriveVehicle());
        addCommand(new NegotiateSale());
        addCommand(new ArrangeFinancing());
        addCommand(new CloseSale());
    }

    public static void main(String[] args) throws Exception {
        Command process = new SellVehicleChain();
        Context ctx = new ContextBase();
        process.execute(ctx);
    }

}
