Instrucciones paso a paso de ejecución:
1. Instalar Intellij, maven y chrome driver según la versión de su chrome
2. Abrir el proyecto en Intellij
3. Buscar la clase CommonStepDefinitions y en la línea 20 modificar con la ruta del chrome driver
4. Abrir un terminal y escribir:
    mvn clean verify -Dcucumber.options="--tags @CompraDosProductos"
5. Visualizar los resultados