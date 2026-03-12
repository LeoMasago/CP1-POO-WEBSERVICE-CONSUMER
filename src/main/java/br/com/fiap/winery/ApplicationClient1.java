package br.com.fiap.winery;

import br.com.fiap.winery.stubclasses.WineStockService;

import br.com.fiap.winery.stubclasses.WineWarningService;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationClient1 {
    static void main(String[] args) throws MalformedURLException {
        final String WSDL = "http://localhost:8080/WineStockService?wsdl";
        final String TARGET = "http://winery.fiap.com.br/";
        final String NAME = "WineStockServiceImplementationService";

        URL url = new URL(WSDL);
        QName qName = new QName(TARGET, NAME);
        Service service = Service.create(url, qName);
        WineStockService wineStockService = service.getPort(WineStockService.class);

        String menu = wineStockService.getMenu();
        System.out.println(menu);

        String order = wineStockService.placeOrder("Vinho", 13);
        System.out.println(order);

        final String WSDL2 = "http://localhost:8080/WineWaringService?wsdl";
        final String NAME2 = "WineWarningServiceImplementationService";

        URL url2 = new URL(WSDL2);
        QName qName2 = new QName(TARGET, NAME2);
        Service service2 = Service.create(url2, qName2);
        WineWarningService wineWarningService = service2.getPort(WineWarningService.class);
        String warn = wineWarningService.sendWarn();
        System.out.println(warn);
    }
}
