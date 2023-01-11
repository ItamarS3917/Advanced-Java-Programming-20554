

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;


import java.util.Calendar;
import java.util.HashMap;

public class CalenderController {

    @FXML
    private ComboBox<String> month;

    @FXML
    private GridPane table;

    @FXML
    private TextArea notes;

    @FXML
    private ComboBox<String> year;

    private HashMap<Calendar, String> hm;

    private Button [] buttons;


    private CalenderDates calenderDates = new CalenderDates();
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


    @FXML
    void monthC(ActionEvent event) {
        cMonth = Integer.parseInt(month.getValue()) - 1;
        calendar.set(Calendar.YEAR, cYear);
        calendar.set(Calendar.MONTH, cMonth);
        initTable();

    }

    @FXML
    void saveData(ActionEvent event) {
        hm.put(calendar, notes.getText());
        notes.clear();
    }

    @FXML
    void yearC(ActionEvent event) {
        int tempYear = Integer.parseInt(year.getValue());
        if(tempYear != cYear) {
            cMonth = 0;
            month.setValue(String.valueOf(FIRST_DAY_OF_A_MONTH));
        }
        cYear = tempYear;
        calendar.set(Calendar.YEAR, cYear);
        calendar.set(Calendar.MONTH, cMonth);
        initTable();

    }

    @FXML
    void initialize() {
        hm = new HashMap<Calendar, String>();
        calendar = Calendar.getInstance();
        initComboBox();
        initTable();

    }

    private void initComboBox() {
        final int DAYS = 31, MONTHS = 12;
        int firstMonth = 0, firstYear = 2020;


        for (int i = 1; i <= MONTHS; i++) {
            month.getItems().add(String.valueOf(i));

        }
        month.setValue(String.valueOf(FIRST_DAY_OF_A_MONTH));


        for (int i = STARTING_YEAR; i <= ENDING_YEAR; i++)
            year.getItems().add(String.valueOf(i));
        year.setValue(String.valueOf(STARTING_YEAR));
        calendar.set(STARTING_YEAR, FIRST_MONTH_0F_A_YEAR, FIRST_DAY_OF_A_MONTH);
    }
    private void initTable() {
        table.getChildren().clear();
        int day = getFirstDayOfWeek();
        System.out.println(day);
        int numDayInMonth = calenderDates.getDaysInMonth(cMonth,cYear);
        int cnt = 0;
        buttons = new Button[TABLE_SIZE];
        for (int i = getFirstDayOfWeek() - 1; i < numDayInMonth  + getFirstDayOfWeek() - 1; i++) {
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

    public int getFirstDayOfWeek() {
        calendar.set(Calendar.DAY_OF_MONTH, FIRST_DAY_OF_A_MONTH);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
    private void handleButton(ActionEvent event) {
        int day = Integer.parseInt(((Button) event.getSource()).getText());
        calendar.set(Calendar.DAY_OF_MONTH, day);
        notes.setText(hm.get(calendar));
    }


}