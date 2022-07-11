# Игра палиндром

#### Класс [Game](src/main/java/com/masharo/tandemTestTasks/game/Game.java) принимает на вход юз кейсы: 
* регистрация нового пользователя [RegistrationUserUseCase](src/main/java/com/masharo/tandemTestTasks/game/usecase/RegistrationUserUseCase.java)
* авторизация пользователя [AuthUserUseCase](src/main/java/com/masharo/tandemTestTasks/game/usecase/AuthUserUseCase.java)
* добавление нового палиндрома [SendWordUseCase](src/main/java/com/masharo/tandemTestTasks/game/usecase/SendWordUseCase.java)

#### Класс [TableLeader](src/main/java/com/masharo/tandemTestTasks/game/TableLeader.java) принимает на вход юз кейс:
* возвращающий список из 5 лучших игроков [TopUserUseCase](src/main/java/com/masharo/tandemTestTasks/game/usecase/TopUsersUseCase.java)

В юз кейсах находится бизнес логика не зависящая от реализации получения или сохранения данных.  
На вход юз кейсы принимают реализацию интерфейса [PalindromeRepository](src/main/java/com/masharo/tandemTestTasks/game/repository/PalindromeRepositoryImpl.java),
в моём случае это [PalindromeRepositoryImpl](src/main/java/com/masharo/tandemTestTasks/game/repository/PalindromeRepositoryImpl.java).
В котором может объеденяться сохранение в несколько стореджей или например, сохраниение в локальную базу
и последующая синхронизация с каким-то удаленным сервисом. В моём случае репозиторий на вход принимает
реализацию интерфейса [PalindromeStorage](src/main/java/com/masharo/tandemTestTasks/game/storage/PalindromeStorage.java), [PalindromeStorageImpl](src/main/java/com/masharo/tandemTestTasks/game/storage/PalindromeStorageImpl.java)
который реализует работу с хранилищем информации [DB](src/main/java/com/masharo/tandemTestTasks/game/data/DB.java).