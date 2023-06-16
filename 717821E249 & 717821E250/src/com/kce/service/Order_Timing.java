package com.kce.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.kce.bean.Menu;

public class Order_Timing {

public void order_at_morning() {
try {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
List<String> dish_order = new ArrayList<String>();
List<Double> dish_prices = new ArrayList<>();
Map<String, Integer> dishes_count = new LinkedHashMap<>();
int[] dish_nos = new int[8];
int i = 0, j = 0, k = 0;
Map<String, Double> compare = Menu.Dishes_List_At_Morning();
// Menu.Dishes_List_At_Morning();
boolean order = true;
while (order) {
System.out.println("-------------------------------------------------------------------------------");
System.out.println("Enter your dish to order : ");
String dish = br.readLine();
if (dish.equals("0")) {
order = false;
break;
}
System.out.println("Enter the count of dishes : ");
dish_nos[i++] = Integer.parseInt(br.readLine());
dishes_count.put(dish, dish_nos[k++]);
for (Map.Entry<String, Double> entry : compare.entrySet()) {
if (entry.getKey().equals(dish)) {
dish_order.add(dish);
dish_prices.add(entry.getValue());
}
}
}
List<Double> prices = new ArrayList<>();
for (double d : dish_prices) {
prices.add(d * dish_nos[j++]);
}

int z = 0;
double bill = 0;
System.out.println(dishes_count);
System.out.println("\t\tYour Orders\n");
for (Entry<String, Integer> entry : dishes_count.entrySet()) {
bill += (entry.getValue() * dish_prices.get(z));

System.out.printf("%10s%20d%30f\n",
entry.getKey(), entry.getValue(), (entry.getValue() * dish_prices.get(z)));
z++;

}
System.out.println("\n-------------------------------------------------------------------------------");
System.out.println("\nTOTAL BILL AMOUNT ------------------------------->" + bill);
} catch (Exception e) {
System.out.println(e);
}
}

public void order_at_afternoon() {
try {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
List<String> dish_order = new ArrayList<String>();
List<Double> dish_prices = new ArrayList<>();
Map<String, Integer> dishes_count = new LinkedHashMap<>();
int[] dish_nos = new int[8];
int i = 0, j = 0, k = 0;
Map<String, Double> compare = Menu.Dishes_List_At_AfterNoon();
// Menu.Dishes_List_At_Morning();
boolean order = true;
while (order) {
System.out.println("-------------------------------------------------------------------------------");
System.out.println("Enter your dish to order : ");
String dish = br.readLine();
if (dish.equals("0")) {
order = false;
break;
}
System.out.println("Enter the count of dishes : ");
dish_nos[i++] = Integer.parseInt(br.readLine());
dishes_count.put(dish, dish_nos[k++]);
for (Map.Entry<String, Double> entry : compare.entrySet()) {
if (entry.getKey().equals(dish)) {
dish_order.add(dish);
dish_prices.add(entry.getValue());
}
}
}
List<Double> prices = new ArrayList<>();
for (double d : dish_prices) {
prices.add(d * dish_nos[j++]);
}

int z = 0;
double bill = 0;

System.out.println("\t\tYours Order \n");
for (Entry<String, Integer> entry : dishes_count.entrySet()) {
bill += (entry.getValue() * dish_prices.get(z));

System.out.printf("%10s%20d%30f\n",
entry.getKey(),entry.getValue(),(entry.getValue() * dish_prices.get(z)));
z++;
}
System.out.println("\n-------------------------------------------------------------------------------");
System.out.println("\nTOTAL BILL AMOUNT -------------------------------> " + bill);
} catch (Exception e) {
System.out.println(e);
}
}

public void order_at_night() {
try {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
List<String> dish_order = new ArrayList<String>();
List<Double> dish_prices = new ArrayList<>();
Map<String, Integer> dishes_count = new LinkedHashMap<>();
int[] dish_nos = new int[8];
int i = 0, j = 0, k = 0;
Map<String, Double> compare = Menu.Dishes_List_At_Night();
// Menu.Dishes_List_At_Morning();
boolean order = true;

while (order) {
System.out.println("-------------------------------------------------------------------------------");
System.out.println("Enter your dish to order : ");
String dish = br.readLine();
if (dish.equals("0")) {
System.out.println("-------------------------------------------------------------------------------");
order = false;
break;
}
System.out.println("Enter the count of dishes : ");
dish_nos[i++] = Integer.parseInt(br.readLine());
dishes_count.put(dish, dish_nos[k++]);
for (Map.Entry<String, Double> entry : compare.entrySet()) {
if (entry.getKey().equals(dish)) {
dish_order.add(dish);
dish_prices.add(entry.getValue());
}
}
}
List<Double> prices = new ArrayList<>();
for (double d : dish_prices) {
prices.add(d * dish_nos[j++]);
}

int z = 0;
double bill = 0;
System.out.println("\t\tYours Orders\n");
for (Entry<String, Integer> entry : dishes_count.entrySet()) {
bill += (entry.getValue() * dish_prices.get(z));
System.out.printf("%10s%20d%30f\n",
entry.getKey() , entry.getValue() , (entry.getValue() * dish_prices.get(z)));
z++;
}
System.out.println("\n-------------------------------------------------------------------------------");
System.out.println("\nTOTAL BILL AMOUNT -------------------------------> " + bill);
} catch (Exception e) {
System.out.println(e);
}
}
}

