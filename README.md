# Sorting Efficiency

Este trabalho em Java tem como objetivo analisar a eficiência de 4 algoritmos de ordenação: o BubbleSort, o InsertionSort, o HeapSort e o MergeSort.

## Comentários do Desenvolvedor
* Não foi feito um arquivo de testes para a classe CSVWriter pois para testar se o arquivo csv está sendo gerado corretamente, basta gerá-lo e comparar com a saída do printf. É muito ineficiente ter que criar todo um processo para ler o arquivo que você gravou (e ainda teria que testar se a leitura está correta), quando você pode fazer isso sozinho.
* caso o ```EfficiencyTest``` seja instanciado com modo "all", todos os quatro algoritmos rodarão. Caso seja instanciado com "nlogn", somente o HeapSort e o MergeSort rodarão. Caso seja instanciado com "n2", somente o BubbleSort e o InsertionSort rodarão.
* A variável ```arrayTypes``` refere-se ao tipo de array (0 para array de int, 1 para array de float e 2 para array de double - O index printado soma 1 a todos). Não instancie ```EfficiencyTest``` com ```numberOfArrayTypes``` maior que 3, ou poderá causar erro.
* O mesmo vale para o ```sortModes``` (1 para array randomico, 2 para array invertido, 3 para array quase ordenado). Não instancia ```EfficiencyTest``` com ```numberOfSortModes``` maior que 3.
* Não instancia ```EfficiencyTest``` com ```minArraySize``` maior que ```maxArraySize```, pois estas variáveis definem o valor mínimo e máximo dos arrays criados. É importante que essas variáveis sejam MÚLTIPLAS DE 10 e POSITIVAS

## CSV gerados
Os arquivos .csv gerados terão vários "parágrafos" compostos de várias linhas. Cada parágrafo desse refere-se a um tamanho de array. Cada linha desse parágrafo corresponderá a um tipo de array e cada membro entre virgulas é o tempo para cada sortMode.  
Abaixo, temos um exemplo de como fica um arquivo CSV, mas adicionamos uns comentários aqui no README para de ajudar a entender o que são cada número.

```
array randômico, array invertido, array quase ordenado

/* Tamanho 10 */
0.0012121,0.0001627,0.0001438, << int
0.0030244,0.000773,0.0007155, << float
0.0008855,0.0004904,0.0003442, << double

/* Tamanho 100 */
0.0073284,0.0046278,0.0042081, << int
0.017148,0.0120761,0.0070016, << float
0.0132958,0.012239,0.0351133, << double

/* Tamanho 1000 */
0.1073198,0.0550685,0.0508482,  << int
0.245066,0.3697069,0.3318733, << float
0.3789186,0.4374417,0.514197, << double
```