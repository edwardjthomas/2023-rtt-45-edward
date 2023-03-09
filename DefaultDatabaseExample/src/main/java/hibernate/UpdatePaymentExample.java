package hibernate;

public class UpdatePaymentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentDAO paymentDao = new PaymentDAO();
		
		// 1) Query the new payment by its id
		Payment payment = paymentDao.findById(274);
		System.out.println(payment.toString());
		// 2) change the check number and the amount
		payment.setAmount(99999.989);
		payment.setCheckNumber("77777777");
		// 3) update the payment
		paymentDao.update(payment);
		
	}

}
