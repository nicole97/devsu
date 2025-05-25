package com.demoblazce.demoblaze.test.steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonStepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;

    @Dado("que usuario ingresa a la página web")
    public void que_usuario_ingresa_a_la_page_web() {

        System.out.println("Iniciando prueba de login...");
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);

        try {
            driver.get("https://www.demoblaze.com/");
            System.out.println("Página abierta exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al abrir la página: " + e.getMessage());
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000);");
    }

    @Dado("usuario selecciona un {string}")
    public void usuario_selecciona_un_producto(String nombreProducto) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(nombreProducto))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Add to cart')]"))).click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), nombreProducto)]")));
    }

    @Dado("usuario navega a la pagina de inicio")
    public void usuario_navega_a_la_pagina_de_inicio() {
        wait = new WebDriverWait(driver, 10);

        driver.findElement(By.xpath("//*[@id='navbarExample']/ul/li[1]/a")).click();

        wait.until(ExpectedConditions.titleContains("STORE")); // Cambia esto según el título esperado de la página de inicio
    }

    @Dado("usuario selecciona comprar para llenar los datos")
    public void usuario_selecciona_comprar_para_llenar_los_datos() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Place Order')]"))).click();
    }

    @Dado("usuario llena datos {string}, {string}, {string}, {string}, {string}, {string}")
    public void usuario_llena_datos(String nombre, String pais, String cuidad, String tarjeta_credito, String mes_expiracion, String anio_expiracion) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

        driver.findElement(By.id("name")).sendKeys(nombre);
        driver.findElement(By.id("country")).sendKeys(pais);
        driver.findElement(By.id("city")).sendKeys(cuidad);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000);");


        driver.findElement(By.id("card")).sendKeys(tarjeta_credito);
        driver.findElement(By.id("month")).sendKeys(mes_expiracion);
        driver.findElement(By.id("year")).sendKeys(anio_expiracion);
    }

    @Dado("da click en  comprar para finalizar")
    public void da_click_en_comprar_para_finalizar() {

        driver.findElement(By.xpath("//button[contains(text(), 'Purchase')]")).click();

    }

    @Entonces("verifica que se creo correctamente la compra")
    public void verifica_que_se_creo_correctamente_la_compra() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sweet-alert")));

        driver.quit();
    }

}