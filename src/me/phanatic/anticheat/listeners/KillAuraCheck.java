
package src.me.phanatic.anticheat.listeners;



import src.me.phanatic.anticheat.api.CheckData;
import src.me.phanatic.anticheat.listeners.ReachCheck;
/*
 *The primary listener call for killaura
 */
public class KillAuraCheck {


	public static void checkA() {
		int swings = 0;
		double LastDifference = 0;
		double difference = 0;
		double Difference = Math.abs(playerHit.getYaw() - playerWhoHit.getYaw());

		if (difference == difference) {
			return;
		}

		if (Difference > 2.0) {
			// sends msg to staff that they might be cheating
			double differenceFinal = Math.abs(LastDifference - Difference);
			if (differenceFinal < 3.0) {
				// need to add player first addCheck();		
				}
		}

	}

    public static void checkA() {
        int swings = 0;


    }


}
