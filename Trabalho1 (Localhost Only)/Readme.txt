Trabalho por: Gustavo Freitas

Condições:

1 - A máquina possui uma versão devidamente atualizada do Java instalada.
2 - Nenhum anti-virus ou firewall bloqueia a execução do arquivo.

Parte do Servidor:

1 - Abra o prompt de comando (como admin).
2 - Vá até o local dos arquivos utilizando "cd Path", onde Path é o caminho do local dos arquivos.
3 - Compile todos os arquivos digitando "javac *.java".
4 - Comece o rmiregistry digitando: "start rmiregistry".
5 - Abra outro prompt de comando (como admin) e vá com ele também ao local dos arquivos utilizando o "cd Path".
6 - Inicialize o servidor digitando: "java NewsServer".

Parte do Cliente:

1 - Abra o prompt de comando (como admin).
2 - Vá até o local dos arquivos utilizando "cd Path", onde Path é o caminho do local dos arquivos.
3 - Compile todos os arquivos digitando "javac *.java".

4a - Para inicializar um subscriber, digite: "java SubscriberClient".
     Você pode sair digitando "exit".

4b - Para inicializar um publisher, digite: "java Publisher".
     Você pode digitar notícias para enviar aos subscribers atuais ao digitar elas e teclar Enter.
     Você pode sair digitando "exit".