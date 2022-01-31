package kr.hs.emirim.w2015.c87

data class UserListModel (
    //  서버에서 넘어오는 정보가 페이지정보등 여러 정보가 넘어옴
    // 이러한 정보 받을려고 선언하면 받을수 잇지만 여기선 유저정보만 받을거임
    // 유저모델에서 생성한 유저객체들을 리스트형태로 저장하기
    var data : List<UserModel>?
)