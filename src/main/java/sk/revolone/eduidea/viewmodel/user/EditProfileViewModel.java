package sk.revolone.eduidea.viewmodel.user;

import sk.revolone.eduidea.data.entity.User;
import sk.revolone.eduidea.viewmodel.BaseViewModel;

public class EditProfileViewModel extends BaseViewModel {
	
	private User user;

	public EditProfileViewModel(User userIn, String message)
	{
		setUser(userIn);
		setMessage(message);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
