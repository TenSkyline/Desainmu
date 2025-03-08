package com.example.desainmu.presentation.common

import com.example.desainmu.data.repository.LocalDataSource
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

//fun initKoin(config: KoinAppDeclaration? = null) =
//    startKoin {
//        config?.invoke(this)
//        modules(
//            provideDataSourceModule,
//            provideRepositoryModule,
//            provideUseCaseModule,
//            provideViewModelModule
//        )
//    }
//val provideDataSourceModule = module {
//    //singleof menjadi object, seperti singleton
//    //factory akan membuat object baru setiap kali dipanggil
//    factory<LocalDataSource> { LocalDataSourceImpl(get()) }
//}
//
//val provideRepositoryModule = module {
//    singleOf(::NoteRepositoryImpl).bind(NoteRepository::class)
//}
//
//val provideUseCaseModule = module {
//    singleOf(::CreateNoteUseCase)
//    singleOf(::GetAllNotesUseCase)
//    singleOf(::DeleteNoteUseCase)
//    singleOf(::UpdateNoteUseCase)
//    singleOf(::GetNoteUseCase)
//}
//
//val provideViewModelModule = module {
//    viewModelOf(::CreateNoteViewModel)
//    viewModelOf(::HomeViewModel)
//}