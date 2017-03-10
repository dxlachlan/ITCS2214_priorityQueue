public class Driver {
	public static void main(String[] args) {

		// create new PriorityQueue Object
		PriorityQueue customerLine = new PriorityQueue();

		// Counter to hold number of customers in line
		int numCust = 0;

		// Counter to hold the total number of customers serviced
		int totalCust = 0;

		// Counter to hold max line length
		int queueLength = 0;

		// simulate 60 minutes of store activity ( 1 minute = 1 iteration)
		for (int i = 0; i < 60; i++) {

			// create a probability for (25%)
			int stat = 0 + (int) ((Math.random() * 100) + 1);

			// check if a new customer is added
			if (stat <= 25) {
				// if yes (add a customer)
				customerLine.add(new PriorityCustomer());
				numCust++;

				// Print Statement Here
				System.out.println("A new customer has been added! The Queue length is now " + numCust);

			}

			if (numCust > queueLength) {
				queueLength = numCust;
			}

			// update the customer object already being serviced
			if (!customerLine.isEmpty()) {

				if (customerLine.getFirst().getServiceTime() == 0) {
					customerLine.remove();
					numCust--;
					System.out.println("A customer has been serviced and removed from the queue. Queue length is now " + numCust);
					totalCust++;

					// Print Statement Here

				} else if (customerLine.getFirst().getServiceTime() != 0) {

					customerLine.getFirst().decServiceTime();

				}

			}

			System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - ");

		}

		System.out.println("The total number of customers serviced is: " + totalCust);
		System.out.println("The max number of people in line at one time is: " + queueLength);

	}

}