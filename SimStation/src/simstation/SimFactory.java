package simstation;

/*
April 11, 2020 -> Added interface so the right view could get passed - Christian Miller
 */
import mvc.AppFactory;
import mvc.*;

public interface SimFactory extends AppFactory {

    View getView(Model model);

}
