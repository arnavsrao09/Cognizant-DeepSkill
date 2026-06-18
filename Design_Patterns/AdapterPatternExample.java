public class AdapterPatternExample {

    public static void main(String[] args) {

        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        PaymentProcessor gpay =
                new GooglePayAdapter(new GooglePayGateway());

        paypal.processPayment(1000);

        stripe.processPayment(2500);

        gpay.processPayment(500);
    }
}

/* =========================
   TARGET INTERFACE
   ========================= */

interface PaymentProcessor {

    void processPayment(double amount);
}

/* =========================
   ADAPTEE CLASSES
   (THIRD PARTY GATEWAYS)
   ========================= */

class PayPalGateway {

    public void sendPayment(double amount) {

        System.out.println(
                "PayPal Payment : " + amount);
    }
}

class StripeGateway {

    public void makeTransaction(double amount) {

        System.out.println(
                "Stripe Transaction : " + amount);
    }
}

class GooglePayGateway {

    public void payMoney(double amount) {

        System.out.println(
                "Google Pay Payment : " + amount);
    }
}

/* =========================
   ADAPTER CLASSES
   ========================= */

class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {

        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {

        paypal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {

        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {

        stripe.makeTransaction(amount);
    }
}

class GooglePayAdapter implements PaymentProcessor {

    private GooglePayGateway gpay;

    public GooglePayAdapter(GooglePayGateway gpay) {

        this.gpay = gpay;
    }

    @Override
    public void processPayment(double amount) {

        gpay.payMoney(amount);
    }
}