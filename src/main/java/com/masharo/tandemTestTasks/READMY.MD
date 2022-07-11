# Игра палиндром

#### Класс [Game](game/Game.java) принимает на вход юз кейсы: 
* регистрация нового пользователя [RegistrationUserUseCase](game/usecase/RegistrationUserUseCase.java)
* авторизация пользователя [AuthUserUseCase](game/usecase/AuthUserUseCase.java)
* добавление нового палиндрома [SendWordUseCase](game/usecase/SendWordUseCase.java)

#### Класс [TableLeader](game/TableLeader.java) принимает на вход юз кейс:
* возвращающий список из 5 лучших игроков [TopUserUseCase](game/usecase/TopUsersUseCase.java)

В юз кейсах находится бизнес логика не зависящая от реализации получения или сохранения данных.  
На вход юз кейсы принимают реализацию интерфейса [PalindromeRepository](game/repository/PalindromeRepositoryImpl.java),
в моём случае это [PalindromeRepositoryImpl](game/repository/PalindromeRepositoryImpl.java).
В котором может объеденяться сохранение в несколько стореджей или например, сохраниение в локальную базу
и последующая синхронизация с каким-то удаленным сервисом. В моём случае репозиторий на вход принимает
реализацию интерфейса [PalindromeStorage](game/storage/PalindromeStorage.java), [PalindromeStorageImpl](game/storage/PalindromeStorageImpl.java)
который реализует работу с хранилищем информации [DB](game/data/DB.java).