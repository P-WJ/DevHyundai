open class ModuleClass {
    private val privateMember = 100       // 외부에서 접근 불가
    public val publicMember = 200         // 어디서나 접근 가능 (기본)
    protected val protectedMember = 300   // 상속 관계에서만 접근 가능
    internal val internalMember = 400     // 같은 모듈 내에서만 접근 가능
}