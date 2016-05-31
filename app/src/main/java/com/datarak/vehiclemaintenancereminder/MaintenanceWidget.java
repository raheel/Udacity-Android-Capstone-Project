package com.datarak.vehiclemaintenancereminder;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemCursor;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemSelection;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class MaintenanceWidget extends AppWidgetProvider {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final String BULLET_POINT = "\u2022";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, String text) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.maintenance_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        views.setTextViewText(R.id.items, text);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        MaintenanceItemSelection selection = new MaintenanceItemSelection();

        selection.isScheduled(Boolean.TRUE);

        MaintenanceItemCursor cursor = selection.query(context.getContentResolver());

        String text = "";
        while(cursor.moveToNext()){
            text += BULLET_POINT + " " + cursor.getDisplayableAction() + " on "
                    + DATE_FORMAT.format(cursor.getMaintenanceDate()) + "\n";
        }

        String title = context.getString(R.string.maintenance_list);
        if (text.equals("")){
            title = context.getString(R.string.no_maintenance);
        }

        text = title + "\n\n" + text;
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, text);
        }
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private static Date getDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        new Date();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}

