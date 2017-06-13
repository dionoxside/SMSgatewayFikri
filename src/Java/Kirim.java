/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import javax.swing.JOptionPane;
import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.Service;

/**
 *
 * @author novan
 */
public class Kirim {
    public void doIt(String PhoneNumber, String Pesan) throws Exception
        {
                OutboundNotification outboundNotification = new OutboundNotification();
                Service.getInstance().setOutboundMessageNotification(outboundNotification);
                Service.getInstance().startService();
                OutboundMessage msg = new OutboundMessage(PhoneNumber,Pesan);
                Service.getInstance().sendMessage(msg);
                if(msg.equals(OutboundMessage.MessageStatuses.FAILED)){
                    JOptionPane.showMessageDialog(null,"Pesan gagal terkirim");
                }else{
                    JOptionPane.showMessageDialog(null,"Pesan Anda terkirim");
//                    JOptionPane.showMessageDialog(null,"Pesan telah terkirim");
                }
                Service.getInstance().stopService();
        }

        public class OutboundNotification implements IOutboundMessageNotification
        {
                public void process(AGateway gateway, OutboundMessage msg)
                {
                        System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
                        System.out.println(msg);
                }
        }
    
}
