package kr.rmsxo.data.usecase.main.setting

import kr.rmsxo.domain.model.Image
import kr.rmsxo.domain.usecase.file.GetImageUseCase
import kr.rmsxo.domain.usecase.file.UploadImageUseCase
import kr.rmsxo.domain.usecase.main.setting.GetMyUserUseCase
import kr.rmsxo.domain.usecase.main.setting.SetMyUserUseCase
import kr.rmsxo.domain.usecase.main.setting.SetProfileImageUseCase
import javax.inject.Inject

class SetProfileImageUseCaseImpl @Inject constructor(
    private val uploadImageUseCase: UploadImageUseCase,
    private val getImageUseCase: GetImageUseCase,
    private val setMyUserUseCase: SetMyUserUseCase,
    private val getMyUserUseCase: GetMyUserUseCase,
) : SetProfileImageUseCase {
    override suspend fun invoke(contentUri: String): Result<Unit> = kotlin.runCatching {
        // 0. 내 정보 가져오기
        val user = getMyUserUseCase().getOrThrow()
        // 1. 이미지 정보 가져오기
        val image: Image =
            getImageUseCase(contentUri = contentUri) ?: throw NullPointerException("이미지를 찾을 수 없습니다")
        // 2. 이미지 서버에 업로드 하기
        val imagePath = uploadImageUseCase(image).getOrThrow()
        // 3. 내 정보 업데이트 하기
        setMyUserUseCase(profileImageUrl = imagePath).getOrThrow()
    }
}