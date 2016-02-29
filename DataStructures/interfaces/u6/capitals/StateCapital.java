package interfaces.u6.capitals;

/** This class stores a state/capital combination. */
public class StateCapital {
	private String state = "";
	private String capital = "";
	
	/** Creates a new StateCapital object given a state and capital. */
	public StateCapital (String state, String capital)
	{
		this.state = state;
		this.capital = capital;
	}
	
	/** This method returns true if the state names match, otherwise false. 
	 * This method is required in order for StateCapitalList.remove() to function
	 * corrected. To implement, you will want to do several things: <BR>
	 * 1) First inspect o to check that it is an instance of StateCapital.  If not, return false.<BR>
	 * 2) Then, cast o to a StateCapital object.<BR>
	 * 3) Finally, compare the state name of this.state and passed object.state.
	 */
	@Override
	public boolean equals (Object o)
	{
		if (o instanceof StateCapital)
		{		
			StateCapital sc = (StateCapital) o;
			return sc.getState().equals(state);
		}
		else {
			return false;
		}
	}

	/** Returns the name of the state. */
	public String getState() {
		return state;
	}

	/** Returns the name of the capital. */
	public String getCapital() {
		return capital;
	}
	
}
