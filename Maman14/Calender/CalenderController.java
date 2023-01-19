import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.util.Calendar;
import java.util.HashMap;

/**
 * The CalenderController class is responsible for handling the interactions between the
 * user and the calender application. It is also responsible for initializing the
 * calender table and comboboxes, as well as saving and displaying notes for specific dates.
 */
public class CalenderController {

    @FXML
    private ComboBox<String> month; // combobox for selecting the month

    @FXML
    private GridPane table; // table for displaying the calender

    @FXML
    private TextArea notes; // text area for displaying and saving notes

    @FXML
    private ComboBox<String> year; // combobox for selecting the year

    private HashMap<Calendar, String> hm; // hashmap for storing notes for specific dates

    private Button [] buttons; // array of buttons for the calender table

    private CalenderDates calenderDates = new CalenderDates(); // instance of CalenderDates class
    private final int FIRST_DAY_OF_A_MONTH = 1;

    private final int FIRST_MONTH_0F_A_YEAR = 0;
    private final int TABLE_SIZE = 42;

    private final int STARTING_YEAR = 2020;
    private final int ENDING_YEAR = 2022;
    private int cYear = STARTING_YEAR;
    private int cMonth= FIRST_MONTH_0F_A_YEAR;

    private final int ROWS = 6;
    private final int COLUMNS = 7;

    private Calendar calendar;

    /**
     * method that is called when the month combobox value is changed
     * sets the current month and updates the calender table
     * @param event
     */
    @FXML
    void monthC(ActionEvent event) {
        cMonth = Integer.parseInt(month.getValue()) - 1;
        calendar.set(Calendar.YEAR, cYear);
        calendar.set(Calendar.MONTH, cMonth);
        initTable();
    }

    /**
     * method that is called when the save button is clicked
     * saves the notes for the current date in the hashmap
     * @param event
     */
    @FXML
    void saveData(ActionEvent event) {
        hm.put(calendar, notes.getText());
        notes.clear();
    }

    /**

     The yearC method is called when the year combobox value is changed.

     It sets the current year and updates the calender table.

     @param event
     */
    @FXML
    void yearC(ActionEvent event) {
        int tempYear = Integer.parseInt(year.getValue());
        //if the year selected is different from the current year, set the current month to January
        if(tempYear != cYear) {
            cMonth = 0;
            month.setValue(String.valueOf(FIRST_DAY_OF_A_MONTH));
        }
        cYear = tempYear;
        calendar.set(Calendar.YEAR, cYear);
        calendar.set(Calendar.MONTH, cMonth);
        initTable();

    }

    /**
     The initialize method is called when the application starts.
     It initializes the HashMap, Calendar instance, and the comboboxes and calender table.
     */
    @FXML
    void initialize() {
        hm = new HashMap<Calendar, String>();
        calendar = Calendar.getInstance();
        initComboBox();
        initTable();

    }

    /**

     The initComboBox method is used to initialize the month and year comboboxes.

     It adds all the months and years between the specified starting and ending year to the comboboxes.

     It also sets the default value of the comboboxes to the first month and year.
     */
    private void initComboBox() {
        final int DAYS = 31, MONTHS = 12;
        int firstMonth = 0, firstYear = 2020;
        // adds all the months to the month combobox
        for (int i = 1; i <= MONTHS; i++) {
            month.getItems().add(String.valueOf(i));
        }
        // sets the default value of the combobox to the first month
        month.setValue(String.valueOf(FIRST_DAY_OF_A_MONTH));

        // adds all the years between the starting and ending year to the year combobox
        for (int i = STARTING_YEAR; i <= ENDING_YEAR; i++) {
            year.getItems().add(String.valueOf(i));
        }
        // sets the default value of the combobox to the first year
        year.setValue(String.valueOf(STARTING_YEAR));
        calendar.set(STARTING_YEAR, FIRST_MONTH_0F_A_YEAR, FIRST_DAY_OF_A_MONTH);
    }

    /**

     The initTable method is used to initialize the calender table.
     It clears any existing children in the table, gets the number of days in the current month and year,
     creates an array of buttons to represent the days in the calender, and adds the buttons to the table.
     */
    private void initTable() {
        // clears any existing children in the table
        table.getChildren().clear();
        int day = getFirstDayOfWeek();
        System.out.println(day);
        int numDayInMonth = calenderDates.getDaysInMonth(cMonth,cYear);
        int cnt = 0;
        buttons = new Button[TABLE_SIZE];
        for (int i = getFirstDayOfWeek() - 1; i < numDayInMonth + getFirstDayOfWeek() - 1; i++) {
            buttons[i] = new Button(""+(cnt + 1));
            cnt++;
            buttons[i].setPrefSize(table.getPrefWidth() / ROWS, table.getPrefHeight() / ROWS);
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    handleButton(event);
                }
            });
            table.add(buttons[i], i % COLUMNS, i / COLUMNS);
        }

    }

    /**

     This method gets the first day of the week for the current month and year.
     It sets the day of the month to the first day of the month and returns the day of the week.
     @return int value representing the first day of the week (1-7, where 1 is Sunday and 7 is Saturday)
     */
    public int getFirstDayOfWeek() {
        calendar.set(Calendar.DAY_OF_MONTH, FIRST_DAY_OF_A_MONTH);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**

     This method is called when a button in the calender table is clicked.
     It gets the day of the month from the button text, sets the calendar to that day,
     and sets the text area to the notes saved for that date in the hashmap.
     @param event - the ActionEvent that triggers the method
     */
    private void handleButton(ActionEvent event) {
        int day = Integer.parseInt(((Button) event.getSource()).getText());
        calendar.set(Calendar.DAY_OF_MONTH, day);
        notes.setText(hm.get(calendar));
    }

}
