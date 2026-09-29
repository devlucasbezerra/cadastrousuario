Como a Api funciona:

As rotas listadas abaixo foram cadastradas:

-- rota principal para listagem de usuários é:
"/usuario/listar"
(Usando o método GET)
com esta rota acima é retornada uma lista de usuários ou a exceção criada chamada de UsuarioNaoEncontradoException.

-- rota para pegar um usuário por email por meio de um RequestParam:
"/usuario"
(Usando o método GET)
use a rota e adicione o email como parâmetro (obrigatório). Caso o email não seja passado ocorre a exceção UsuarioNaoEncontradoException.


-- rota para adicionar o(s) usuário(s):
"/usuario"
(Usando o método POST)
com esta rota o(s) usuário(s) são adicionados por meio de um RequestBody com os atributos de "name" para nome e "email" para email.


-- rota para deletar por email
"/usuario"
(Usando o método DELETE)
Aqui eu optei por usar o email pois ele é um dos atributos únicos de um devido usuário, assim como o id, porém, optei por usar o email.
com esta rota, passando o email como parâmetro e usando um RequestParam, apagamos o usuário.

-- rota para atualizar o usuário:
"/usuario"
(Usando o método PUT)
com esta rota é possível atualizar os dados de um usuário específico usando o RequestParam que neste caso é o id (obrigatório) e passando a atualização dos dados por meio de um body.
Caso seja esquecido de passar algum dado, o sistema já está programado para deixar os dados que já estavam antes da atualização, modificando apenas e os dados que foram atualizados e evitando apagar os dados não informados.
