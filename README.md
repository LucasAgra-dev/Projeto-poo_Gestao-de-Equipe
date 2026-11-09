# Sistema de Gerenciamento de Clube de Futebol

## Descrição das Funcionalidades
O **FutManager CLI** é um sistema desenvolvido em Java para gerenciar os membros de um clube de futebol profissional. O sistema conta com os pilares da Programação Orientada a Objetos (Encapsulamento, Herança, Abstração e Polimorfismo) e oferece as seguintes operações de CRUD via CLI:

1. **Adicionar Membro:** Permite cadastrar Jogadores (Atacante, Goleiro), Corpo Técnico (Técnico) e Diretoria (Diretor) com validações básicas e campos específicos por categoria.
2. **Listar Elenco:** Exibe as informações detalhadas de cada membro cadastrado e calcula dinamicamente os salários totais com base em gratificações e bonificações de cada função.
3. **Atualizar Registros:** Permite alterar dados como nome, idade e salário base utilizando a busca por ID.
4. **Remover Registros:** Permite a demissão/desligamento de qualquer profissional cadastrado.

---

## Como Executar o Projeto

### Pré-requisitos
* Java Development Kit (JDK) versão 8 ou superior instalado.

### Passo a Passo

1. **Abrir o Terminal/Prompt de Comando:**
   Navegue até a pasta `src` do projeto:
   ```bash
   cd caminho/para/o/projeto/src
