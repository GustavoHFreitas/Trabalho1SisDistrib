Trabalho por: Gustavo Freitas

Condições:

1 - Ambos os ambientes devem ter uma versão devidamente atualizada do Java instalado.
2 - Ambos os computadores estão conectados a mesma network (exemplo: Wi-Fi).
3 - Ambos os computadores possuem os mesmos arquivos .java.
4 - Garanta que nenhum anti-virus ou firewall bloqueie a conexão em ambos os computadores.
5 - Garanta que ambos os computadores podem mandar um ping um para o outro (Você pode digiar, no prompt de comando: "ping Ip2" para conferir, onde Ip2 é o IP do outro computador).

No Servidor:

1 - Abra o prompt de comando (como admin).
2 - Vá até o local dos arquivos utilizando "cd Path", onde Path é o caminho do local dos arquivos.
3 - Compile todos os arquivos digitando "javac *.java".
4 - Comece o rmiregistry digitando: "start rmiregistry".
5 - Abra outro prompt de comando (como admin) e vá com ele também ao local dos arquivos utilizando o "cd Path".
6 - Inicialize o servidor digitando: "java NewsServer".
7 - Você receberá o IP do servidor.

No Cliente:

1 - Abra o prompt de comando (como admin).
2 - Vá até o local dos arquivos utilizando "cd Path", onde Path é o caminho do local dos arquivos.
3 - Compile todos os arquivos digitando "javac *.java".

4a - Para inicializar um subscriber, digite: "java SubscriberClient" e ao ser requisitado um IP digite o IP do servidor obtido (ou deixe em branco para usar o localhost).
     Você pode sair digitando "exit".

4b - Para inicializar um publisher, digite: "java Publisher" e ao ser requisitado um IP digite o IP do servidor obtido (ou deixe em branco para usar o localhost).
     Você pode digitar notícias para enviar aos subscribers atuais ao digitar elas e teclar Enter.
     Você pode sair digitando "exit".